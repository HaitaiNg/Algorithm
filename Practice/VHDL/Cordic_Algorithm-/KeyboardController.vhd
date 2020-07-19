

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity kbcontroller is
    Port ( CLK : in  STD_LOGIC; -- input clock
           RST : in  STD_LOGIC; -- reset
           KD : in  STD_LOGIC; --kd
           KC : in  STD_LOGIC; -- kc
			  sine_select : out STD_LOGIC; --output sine or cosine
			  calc_en : out STD_LOGIC; -- to start calculation
			  angle : out STD_LOGIC_VECTOR (11 downto 0);
			  neg_result : out STD_LOGIC); -- to remove and put in cordic main
end kbcontroller;

architecture Behavioral of kbcontroller is

--------------------------------------------------------
-- Internal signal declarations
-------------------------------------------------------
signal clkDiv : std_logic_vector(12 downto 0);
signal pclk : std_logic;
signal KDI, KCI : std_logic;
signal DFF1, DFF2 : std_logic;
signal ShiftRegSig1 : std_logic_vector(10 downto 0);
signal ShiftRegSig2 : std_logic_vector(10 downto 1);
signal MUXOUT : std_logic_vector(3 downto 0);
signal waitReg : std_logic_vector(7 downto 0);
-- new signals
signal sign_neg : std_logic;
signal key_state : integer;
signal clearReg : std_logic;
signal sine : std_logic;
signal en_out : std_logic:= '0';
signal reg1 : std_logic_vector (3 downto 0);
signal reg2 : std_logic_vector (3 downto 0);
signal reg3 : std_logic_vector (3 downto 0);

begin
CLKDivider: process (CLK)
begin
	if (CLK = '1' and CLK'event) then
		clkDiv <= clkDiv + 1;
   end if;
end process;

pclk <= clkDiv(3);

process (pclk, RST, KC, KD)
begin
	if (RST = '1') then
		DFF1 <= '0';
		DFF2 <= '0';
		KDI <= '0';
		KCI <= '0';
	else
		if(pclk = '1' and pclk'event) then
			DFF1 <= KD;
			KDI <= DFF1;
			DFF2 <= KC;
			KCI <= DFF2;
		end if;
	end if;
end process;

--Shift registers used to clock the scan codes out
process (KDI, KCI, RST)
begin
	if (RST = '1') then
		ShiftRegSig1 <= "00000000000";
		ShiftRegSig2 <= "0000000000";
	else
		if (KCI = '0' and KCI'event) then
			ShiftRegSig1(10 downto 0) <= KDI & ShiftRegSig1(10 downto 1);
			ShiftRegSig2(10 downto 1) <= ShiftRegSig1(0) & ShiftRegSig2(10 downto 2);
		end if;
	end if;
end process;

process (ShiftRegSig1, ShiftRegSig2,RST, KCI,clearReg)
begin
	if (RST = '1') then
		WaitReg <= "00000000";
	else
		if (KCI'event and KCI = '1' and ShiftRegSig2(8 downto 1) = "11110000") then
			waitReg <= ShiftRegSig1(8 downto 1);
		end if;

		if (clearReg = '1') then
			waitReg <= "00000000";
		end if;

	end if;
end process;

process(pclk,rst)
begin

	if (RST = '1') then
		sign_neg <= '0'; --if 1, the input angle is negative
		key_state <= 0; --signal to hold state FSM
		reg1 <= "0000"; -- hundreds place of angle in bcd
		reg2 <= "0000"; --tens place of angle in bcd
		reg3 <= "0000"; --holds units place of angle in bcd
		en_out <= '0';  --output enable

	elsif (pclk'event and pclk = '1') then

		case key_state is

			when 0 =>
				if (waitReg = "01010101") then -- if positive sign (55)
					sign_neg <= '0';
					key_state <= 1;
				elsif (waitReg = "01001110") then -- if 4E
					sign_neg <= '1';
					key_state <= 1;
				end if;


			when 1 =>

				clearReg <= '1';	--signal for clearing waitReg
				key_state <= 2;

			when 2 =>

				clearReg <= '0';
				if (waitReg = "01000101") then --if '0' key
					reg1 <= "0000";		 --hund's place=0
					key_state <= 3;		 --next state
				elsif (waitReg = "00010110") then -- '1'
					reg1 <= "0001";
					key_state <= 3;
				elsif (waitReg = "00011110") then --  '2'
					reg1 <= "0010";
					key_state <= 3;
				elsif (waitReg = "00100110") then --  '3'
					reg1 <= "0011";
					key_state <= 3;
				elsif (waitReg = "00100101") then --  '4'
					reg1 <= "0100";
					key_state <= 3;
				elsif (waitReg = "00101110") then --  '5'
					reg1 <= "0101";
					key_state <= 3;
				elsif (waitReg = "00110110") then --  '6'
					reg1 <= "0110";
					key_state <= 3;
				elsif (waitReg = "00111101") then -- '7'
					reg1 <= "0111";
					key_state <= 3;
				elsif (waitReg = "00111110") then --  '8'
					reg1 <= "1000";
					key_state <= 3;
				elsif (waitReg = "01000110") then --  '9'
					reg1 <= "1001";
					key_state <= 2;

				else
					key_state <= 2; --no key pressed or invalid key
				end if;		    --so stay in this state

			when 3 =>

				clearReg <= '1';	--signal for clearing waitReg
				key_state <= 4;

			when 4 =>

				clearReg <= '0';
				if (waitReg = "01000101") then --if '0' key
					reg2 <= "0000";		 --hund's place=0
					key_state <= 5;		 --next state
				elsif (waitReg = "00010110") then -- '1'
					reg2 <= "0001";
					key_state <= 5;
				elsif (waitReg = "00011110") then --  '2'
					reg2 <= "0010";
					key_state <= 5;
				elsif (waitReg = "00100110") then --  '3'
					reg2 <= "0011";
					key_state <= 5;
				elsif (waitReg = "00100101") then --  '4'
					reg2 <= "0100";
					key_state <= 5;
				elsif (waitReg = "00101110") then --  '5'
					reg2 <= "0101";
					key_state <= 5;
				elsif (waitReg = "00110110") then --  '6'
					reg2 <= "0110";
					key_state <= 5;
				elsif (waitReg = "00111101") then --  '7'
					reg2 <= "0111";
					key_state <= 5;
				elsif (waitReg = "00111110") then --  '8'
					reg2 <= "1000";
					key_state <= 5;
				elsif (waitReg = "01000110") then --  '9'
					reg2 <= "1001";
					key_state <= 5;

				else
					key_state <= 4; --no key pressed or invalid key
				end if;		    --so stay in this state

			when 5 =>
				clearReg <= '1';	--signal for clearing waitReg
				key_state <= 6;

			when 6 =>
				clearReg <= '0';
				if (waitReg = "01000101") then --if '0' key
					reg3 <= "0000";		 --hund's place=0
					key_state <= 7;		 --next state
				elsif (waitReg = "00010110") then --16 = '1' key
					reg3 <= "0001";
					key_state <= 7;
				elsif (waitReg = "00011110") then -- 1E = '2' key
					reg3 <= "0010";
					key_state <= 7;
				elsif (waitReg = "00100110") then -- 26 = '3' key
					reg3 <= "0011";
					key_state <= 7;
				elsif (waitReg = "00100101") then -- 25 = '4' key
					reg3 <= "0100";
					key_state <= 7;
				elsif (waitReg = "00101110") then -- 25 = '5' key
					reg3 <= "0101";
					key_state <= 7;
				elsif (waitReg = "00110110") then -- 36 = '6' key
					reg3 <= "0110";
					key_state <= 7;
				elsif (waitReg = "00111101") then -- 3D = '7' key
					reg3 <= "0111";
					key_state <= 7;
				elsif (waitReg = "00111110") then -- 3E = '8' key
					reg3 <= "1000";
					key_state <= 7;
				elsif (waitReg = "01000110") then -- 46 = '9' key
					reg3 <= "1001";
					key_state <= 7;
				else
					key_state <= 6; --no key pressed or invalid key
				end if;		    -- stay in this state

			when 7=>
				clearReg <= '1';	-- clear waitReg
				key_state <= 8;

			when 8 => -- if S select sine/ if C select cos
				clearReg <= '0';
				if (waitReg = "00011011") then --'S' key
					sine <= '0'; -- choose sine
					key_state <= 9;
				elsif (waitReg = "00100001") then -- 'C' key
					sine <= '1'; --choose cos
					key_state <= 9;
				else
			      key_state <= 8;
				end if;

			when 9 =>
				en_out <= '1';

			when others =>
			   key_state <= 0;
		end case;

	calc_en <= en_out;
	sine_select <= sine;
	angle <= reg1 & reg2 & reg3;
	neg_result<= sign_neg;
	end if;

end process;
end Behavioral;
