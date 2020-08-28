
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
USE IEEE.STD_LOGIC_UNSIGNED.ALL;


entity vgacontroller is
    Port ( mclk : in  STD_LOGIC; -- master clock -- assign mclk
			x_enable: in STD_LOGIC_VECTOR(8 downto 0);
			o_enable: in STD_LOGIC_VECTOR(8 downto 0);
           hs : out  STD_LOGIC; -- horizontal sync -- assign hs
           vs : out  STD_LOGIC; -- vertical sync  -- assign vs
           red : out  STD_LOGIC_VECTOR (3 downto 0); --assign red
           grn : out  STD_LOGIC_VECTOR (3 downto 0); -- assign grn
           blu : out  STD_LOGIC_VECTOR (3 downto 0)); --assign blu
end vgacontroller;

architecture Behavioral of vgaController is

	component charrom
		port(
			addr: IN std_logic_vector(5 downto 0);
			clk: IN std_logic;
			dout: OUT std_logic_vector(19 downto 0)
			);
		end component;

	--Value of pixels in a horizontal line (800 - 1) (index starts at 0)
	constant hpixels	: std_logic_vector(9 downto 0) := "1100011111";

--Number of horizontal lines in the display (521 - 1) (index starts at 0)
	constant vlines	: std_logic_vector(9 downto 0) := "1000001000";

	--Horizontal back porch (144) which is Tpw + Tbp
	constant hbp	: std_logic_vector(9 downto 0) := "0010010000";

	--Horizontal front porch (784) Tpw + Tbp + Tdisp
	--Horizontal front porch (784) Tpw + Tbp + Tdisp
	constant hfp	: std_logic_vector(9 downto 0) := "1100010000";

	--Vertical back porch (31) which is Tpw + Tbp
	constant	vbp	: std_logic_vector(9 downto 0) := "0000011111";

	--Vertical front porch (511) Tpw + Tbp + Tdisp
	constant vfp	: std_logic_vector(9	downto 0) := "0111111111";

	signal hc, vc: std_logic_vector(9 downto 0);		 --These are the Horizontal and Vertical counters
	signal clkdiv: std_logic;				 				--Clock divider
	signal clkcount: std_logic_vector(1 downto 0);		-- Clock Counter
	signal vidon: std_logic;				 				--Tells whether or not its ok to display data
	signal vsenable: std_logic;				 			--Enable for the Vertical counter

	signal dout: std_logic_vector(19 downto 0); -- dout signal
	signal addr: std_logic_vector(5 downto 0);  -- address signal
	signal ROM_word_index: integer; -- rom integer signal

	-- 453
	constant hc_start: std_logic_vector(9 downto 0) := "0111000101";
	-- 473
	constant hc_end: std_logic_vector(9 downto 0) := "0111011001";
	-- 249
	constant vc_start: std_logic_vector(9 downto 0) := "0011111001";
	-- 290
	constant vc_end: std_logic_vector(9 downto 0) := "0100100010";
	-- 270
	constant vc_xo: std_logic_vector(9 downto 0) := "0100001110";

	-- 252
	constant hc2_start: std_logic_vector(9 downto 0) := "0011111100";
	-- 274
	constant hc2_end: std_logic_vector(9 downto 0) := "0100010010";
	--666
	constant hc3_start: std_logic_vector(9 downto 0) := "1010011010";
	--687
	constant hc3_end: std_logic_vector(9 downto 0) := "1010101111";

		-- 76
	constant vc2_start: std_logic_vector(9 downto 0) := "0001001100";
	-- 116
	constant vc2_end: std_logic_vector(9 downto 0) := "0001110100";
	-- 411
	constant vc3_start: std_logic_vector(9 downto 0) := "0110011011";
	-- 453
	constant vc3_end: std_logic_vector(9 downto 0) := "0111000101";

	-- 96
	constant vc2_xo: std_logic_vector(9 downto 0) := "0001100000"; -- Middle of row 1
	-- 431
	constant vc3_xo: std_logic_vector(9 downto 0) := "0110101111"; -- Middle of row 3


begin

	charrom_c: charrom port map(addr, mclk, dout);

	--This divides the 100Mhz clock in quarter (25MHz pixel clock)
	process(mclk)
	begin
		if(mclk = '1' and mclk'EVENT) then
			clkcount <= clkcount + 1;
		end if;
	end process;

	clkdiv <= clkcount(1);

	--Runs the horizontal counter
	process(clkdiv)
	begin
		if(clkdiv = '1' and clkdiv'EVENT) then
			if hc = hpixels then			 --If the counter has reached the end of pixel count
				hc <= "0000000000";	 --reset the counter
				ROM_word_index <= 0;

			else
				hc <= hc + 1;		--Increment the horizontal counter

				if(hc > hc_start and hc < hc_end)
				or (hc > hc2_start and hc < hc2_end) or (hc > hc3_start and hc < hc3_end)
				then
					ROM_word_index <= ROM_word_index + 1;
				else
					ROM_word_index <= 0;
				end if;

			end if;
		end if;
	end process;

	vsenable <= '1' when hc = hpixels else '0';		--Enable the vertical counter to increment

	hs <= '1' when hc >=  "0001100000" else '0';		 --Horizontal Sync Pulse

	process(clkdiv, vsenable)
	begin
	if(clkdiv = '1' and clkdiv'EVENT and vsenable = '1') then	 --Increment when enabled
		if vc = vlines then				 --Reset when the number of lines is reached
			vc <= "0000000000";
			addr <= "000000"; -- reset address
		else
			vc <= vc + 1;				--Increment the vertical counter

				if(vc > vc_start and vc < vc_end)
				or (vc > vc2_start and vc < vc2_end) or (vc > vc3_start and vc < vc3_end)
				then
					addr <= addr + 1;
				else
					addr <= "000000";
				end if;

		end if;
	end if;
	end process;

	vs <= '1' when vc >= "0000000010" else '0';	 --Vertical Sync Pulse

  	-- Red vertical lines at 358 and 570
	red <= "1111" when (hc = "101100110" and vidon = '1') or (hc = "1000111010" and vidon = '1') else "0000";
	-- Green horizontal lines at 191 and 351
	grn <= "1111" when (vc = "10111111" and vidon = '1') or (vc = "101011111" and vidon = '1') else "0000";

	-- No Blue pixels
	blu <= "1111" when

	--block 1
		(((vc > vc_start and vc < vc_xo ) and (hc > hc2_start and hc < hc2_end ) and dout(ROM_word_index) = '1' and vidon = '1' and x_enable(0) = '1')
		or
		((vc > vc_xo and vc < vc_end ) and (hc > hc2_start and hc < hc2_end ) and dout(ROM_word_index) = '1' and vidon = '1' and o_enable(0) = '1')
		or
	--block 2
		((vc > vc_start and vc < vc_xo) and (hc > hc_start and hc < hc_end) and dout(ROM_word_index) = '1' and vidon = '1' and x_enable(1) = '1')
		 or
		((vc > vc_xo and vc < vc_end) and (hc > hc_start and hc < hc_end) and dout(ROM_word_index) = '1' and vidon = '1' and o_enable(1) = '1')
		or
	--block 3
		((vc > vc_start and vc < vc_xo) and (hc > hc3_start and hc < hc3_end) and dout(ROM_word_index) = '1' and vidon = '1' and x_enable(2) = '1')
		 or
		((vc > vc_xo and vc < vc_end) and (hc > hc3_start and hc < hc3_end) and dout(ROM_word_index) = '1' and vidon = '1' and o_enable(2) = '1')
		or
	-- block 5
		((vc > vc2_start and vc < vc2_xo) and (hc > hc_start and hc < hc_end) and dout(ROM_word_index) = '1' and vidon = '1' and x_enable(4) = '1')
		 or
		((vc > vc2_xo and vc < vc2_end) and (hc > hc_start and hc < hc_end) and dout(ROM_word_index) = '1' and vidon = '1' and o_enable(4) = '1')
		or
	-- block 4
		((vc > vc2_start and vc < vc2_xo) and (hc > hc2_start and hc < hc2_end ) and dout(ROM_word_index) = '1' and vidon = '1' and x_enable(3) = '1')
		or
		((vc > vc2_xo and vc < vc2_end ) and (hc > hc2_start and hc < hc2_end ) and dout(ROM_word_index) = '1' and vidon = '1' and o_enable(3) = '1')
		or
	-- block 6
		((vc > vc2_start and vc < vc2_xo) and (hc > hc3_start and hc < hc3_end) and dout(ROM_word_index) = '1' and vidon = '1' and x_enable(5) = '1')
		 or
		((vc > vc2_xo and vc < vc2_end) and (hc > hc3_start and hc < hc3_end) and dout(ROM_word_index) = '1' and vidon = '1' and o_enable(5) = '1')
		or
	-- block 7
		((vc > vc3_start and vc < vc3_xo ) and (hc > hc2_start and hc < hc2_end ) and dout(ROM_word_index) = '1' and vidon = '1' and x_enable(6) = '1')
		or
		((vc > vc3_xo and vc < vc3_end ) and (hc > hc2_start and hc < hc2_end ) and dout(ROM_word_index) = '1' and vidon = '1' and o_enable(6) = '1')
		or
	-- block 8
		((vc > vc3_start and vc < vc3_xo) and (hc > hc_start and hc < hc_end) and dout(ROM_word_index) = '1' and vidon = '1' and x_enable(7) = '1')
		 or
		((vc > vc3_xo and vc < vc3_end) and (hc > hc_start and hc < hc_end) and dout(ROM_word_index) = '1' and vidon = '1' and o_enable(7) = '1')
		or
	--block 9
		((vc > vc3_start and vc < vc3_xo) and (hc > hc3_start and hc < hc3_end) and dout(ROM_word_index) = '1' and vidon = '1' and x_enable(8) = '1')
		 or
		((vc > vc3_xo and vc < vc3_end) and (hc > hc3_start and hc < hc3_end) and dout(ROM_word_index) = '1' and vidon = '1' and o_enable(8) = '1')
		)
		else "0000";

 --Enable video out when within the porches
	vidon <= '1' when (((hc < hfp) and (hc >= hbp)) and ((vc < vfp) and (vc >= vbp))) else '0';


end Behavioral;
