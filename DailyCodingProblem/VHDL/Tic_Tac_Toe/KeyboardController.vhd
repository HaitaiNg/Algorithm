----------------------------------------------------------------------------------
-- Company:
-- Engineer:
--
-- Create Date:    14:40:00 10/27/2016
-- Design Name:
-- Module Name:    kbcontroller - Behavioral
-- Project Name:
-- Target Devices:
-- Tool versions:
-- Description:
--
-- Dependencies:
--
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity kbcontroller is
    Port ( CLK : in  STD_LOGIC; -- 100 Mhz Clock
           RST : in  STD_LOGIC;
           KD : in  STD_LOGIC; -- Keyboard serial data
           KC : in  STD_LOGIC; --Keyboard clock
           an : out  STD_LOGIC_VECTOR (7 downto 0); -- anode control signal
           sseg : out  STD_LOGIC_VECTOR (6 downto 0);
			  x_enable: out STD_LOGIC_VECTOR(8 downto 0);
			  o_enable: out STD_LOGIC_VECTOR(8 downto 0)); -- 0 = o turn, 1 = x turn
end kbcontroller;

architecture Behavioral of kbcontroller is
--------------------------------------------------------
-- signal declarations
-------------------------------------------------------

signal clkDiv : std_logic_vector(12 downto 0);
signal sclk, pclk : std_logic;
signal KDI, KCI : std_logic;
signal DFF1, DFF2 : std_logic;
signal ShiftRegSig1 : std_logic_vector(10 downto 0);
signal ShiftRegSig2 : std_logic_vector(10 downto 1);
signal MUXOUT : std_logic_vector(3 downto 0);
signal waitReg : std_logic_vector(7 downto 0);

signal turn: STD_LOGIC:= '0'; -- turn is in internal signal
signal x_enable_internal: STD_LOGIC_VECTOR(8 downto 0); -- internal x
signal o_enable_internal: STD_LOGIC_VECTOR(8 downto 0); --internal o

--------------------------------------------------------
-- module implementation
--------------------------------------------------------

begin
CLKDivider: process (CLK)
begin
	if (CLK = '1' and CLK'event) then
		clkDiv <= clkDiv + 1;
   end if;
end process;

sclk <= clkDiv(12);
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

process (ShiftRegSig1, ShiftRegSig2,RST, KCI)
begin
	if (RST = '1') then
		WaitReg <= "00000000";
	else
		if (KCI'event and KCI = '1' and ShiftRegSig2(8 downto 1) = "11110000") then
			waitReg <= ShiftRegSig1(8 downto 1);
		end if;
	end if;
end process;
------------------------------
process(pclk,rst)
begin

if (RST = '1') then

		turn <= '0';
		x_enable_internal <= "000000000"; -- enable bits for x
		o_enable_internal <= "000000000"; -- enable bits for o

elsif (pclk'event and pclk = '1') then

	-- block 1 -- A
	if ((waitReg = x"1C") and x_enable_internal(0)='0' and o_enable_internal(0)='0') then

		if(turn = '1') then
			x_enable_internal(0) <= '1';
		else
			o_enable_internal(0) <= '1';
		end if;

		turn <= not turn;
	end if;

	-- block 2 -- S
	if ((waitReg = x"1B") and x_enable_internal(1)='0' and o_enable_internal(1)='0') then

		if(turn = '1') then
			x_enable_internal(1) <= '1';
		else
			o_enable_internal(1) <= '1';
		end if;

		turn <= not turn;
	end if;

	-- block 3 -- D
		if ((waitReg = x"23") and x_enable_internal(2)='0' and o_enable_internal(2)='0') then

		if(turn = '1') then
			x_enable_internal(2) <= '1';
		else
			o_enable_internal(2) <= '1';
		end if;

		turn <= not turn;
	end if;

	-- block 4 -- W
		if ((waitReg = x"15") and x_enable_internal(3)='0' and o_enable_internal(3)='0') then

		if(turn = '1') then
			x_enable_internal(3) <= '1';
		else
			o_enable_internal(3) <= '1';
		end if;

		turn <= not turn;
	end if;

	-- block 5 -- Q
		if ((waitReg = x"1D") and x_enable_internal(4)='0' and o_enable_internal(4)='0') then

		if(turn = '1') then
			x_enable_internal(4) <= '1';
		else
			o_enable_internal(4) <= '1';
		end if;

		turn <= not turn;
	end if;

	-- block 6 -- E
		if ((waitReg = x"24") and x_enable_internal(5)='0' and o_enable_internal(5)='0') then

		if(turn = '1') then
			x_enable_internal(5) <= '1';
		else
			o_enable_internal(5) <= '1';
		end if;

		turn <= not turn;
	end if;

	-- block 7 -- Z
		if ((waitReg = x"1A") and x_enable_internal(6)='0' and o_enable_internal(6)='0') then

		if(turn = '1') then
			x_enable_internal(6) <= '1';
		else
			o_enable_internal(6) <= '1';
		end if;

		turn <= not turn;
	end if;

	-- block 8 -- X
		if ((waitReg = x"22") and x_enable_internal(7)='0' and o_enable_internal(7)='0') then

		if(turn = '1') then
			x_enable_internal(7) <= '1';
		else
			o_enable_internal(7) <= '1';
		end if;

		turn <= not turn;
	end if;

	-- block 9 -- V
		if ((waitReg = x"2A") and x_enable_internal(8)='0' and o_enable_internal(8)='0') then

		if(turn = '1') then
			x_enable_internal(8) <= '1';
		else
			o_enable_internal(8) <= '1';
		end if;

		turn <= not turn;
	end if;


end if;
end process;


x_enable <= x_enable_internal;
o_enable <= o_enable_internal;

--multiplexer
MUXOUT <= waitReg(7 downto 4) when sclk = '0' else
			 waitReg(3 downto 0);

--Seven segment decoder
sseg <= "1000000" when MUXOUT = "0000" else
		  "1111001" when MUXOUT = "0001" else
		  "0100100" when MUXOUT = "0010" else
		  "0110000" when MUXOUT = "0011" else
		  "0011001" when MUXOUT = "0100" else
		  "0010010" when MUXOUT = "0101" else
		  "0000010" when MUXOUT = "0110" else
		  "1111000" when MUXOUT = "0111" else
		  "0000000" when MUXOUT = "1000" else
		  "0010000" when MUXOUT = "1001" else
		  "0001000" when MUXOUT = "1010" else
		  "0000011" when MUXOUT = "1011" else
		  "1000110" when MUXOUT = "1100" else
		  "0100001" when MUXOUT = "1101" else
		  "0000110" when MUXOUT = "1110" else
		  "0001110" when MUXOUT = "1111" else
		  "1111111";

--anode divider
an(7 downto 2) <= "111111";
an(1 downto 0) <= "10" when sclk = '1' else  "01";

end Behavioral;
