-- Convert the 17 bit value into a displayable format

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
entity cordic_out is
    Port ( out_bin : in  STD_LOGIC_VECTOR(16 downto 0);
           out_en : in  STD_LOGIC;
           neg_result : in STD_LOGIC;
			  CLK : in STD_LOGIC;
			  rst : in STD_LOGIC;
			  an : out  STD_LOGIC_VECTOR (7 downto 0);
           sseg : out  STD_LOGIC_VECTOR (6 downto 0));
end cordic_out;

architecture Behavioral of cordic_out is
signal MUXOUT : std_logic_vector(3 downto 0);
signal sclk : std_logic;
signal clkDiv : std_logic_vector(12 downto 0);
signal an_state : integer;
signal neg_num : STD_LOGIC;
signal reg1 : std_logic_vector (3 downto 0);
signal reg2 : std_logic_vector (3 downto 0);
signal reg3 : std_logic_vector (3 downto 0);
signal BCD_signal : std_logic_vector (11 downto 0) := "000000000000";

begin
CLKDivider: process (CLK)
begin
	if (CLK = '1' and CLK'event) then
		clkDiv <= clkDiv + 1;
   end if;
end process;
sclk <= clkDiv(12);


--------------------------------------
-- Double Dabble Algorithm -----
-- Modified version of the double dabble algoritm
--------------------------------------
process(out_en)

  -- temporary variable
  variable temp : STD_LOGIC_VECTOR (16 downto 0);
  variable bcd : std_logic_vector (11 downto 0) := (others => '0');

  begin
    bcd := (others => '0');
    temp(16 downto 0) := out_bin;

    for i in 1 to 16 loop

	 	bcd := temp(0) & bcd(11 downto 1);
		temp := '0' & temp(16 downto 1);

      if bcd(3 downto 0) > 4 then
        bcd(3 downto 0) := bcd(3 downto 0) - 3;
      end if;

      if bcd(7 downto 4) > 4 then
        bcd(7 downto 4) := bcd(7 downto 4) - 3;
      end if;

      if bcd(11 downto 8) > 4 then
        bcd(11 downto 8) := bcd(11 downto 8) - 3;
      end if;

    end loop;
	BCD_signal <= bcd;
  end process bcd1;

neg_num <= neg_result;
reg1 <= BCD_signal(11 downto 8);
reg2 <= BCD_signal(7 downto 4);
reg3 <= BCD_signal(3 downto 0);

process(sclk,rst)
begin
	if rst = '1' then
		an_state <= 0;
		an <= "00000000";
	elsif sclk'event and sclk = '1' then

		case an_state is

			when 0 =>
				an <= "11110111";
				if(neg_result = '1')then
					MUXOUT <= "1010";
				else
					MUXOUT <= "1011";
				end if;

				an_state <= 1;

			when 1 =>
				an <= "11111011";
			   MUXOUT <= reg1;
				an_state <= 2;
			when 2 =>
				an <= "11111101";
				MUXOUT <= reg2;
				an_state <= 3;
			when 3 =>
			   MUXOUT <= reg3;
				an <= "11111110";
				an_state <= 0;
		   when others =>
			   an_state <= 0;

		end case;
	end if;
end process;

sseg <= "1000000" when MUXOUT = "0000" else -- 1
		  "1111001" when MUXOUT = "0001" else -- 2
		  "0100100" when MUXOUT = "0010" else -- 3
		  "0110000" when MUXOUT = "0011" else -- 4
		  "0011001" when MUXOUT = "0100" else -- 5
		  "0010010" when MUXOUT = "0101" else -- 6
		  "0000010" when MUXOUT = "0110" else -- 7
		  "1111000" when MUXOUT = "0111" else -- 8
		  "0000000" when MUXOUT = "1000" else -- 9
		  "0010000" when MUXOUT = "1001" else
	     "0001000" when MUXOUT = "1010" else
		  "0000011" when MUXOUT = "1011" else
		  "1000110" when MUXOUT = "1100" else
		  "0100001" when MUXOUT = "1101" else
		  "0000110" when MUXOUT = "1110" else
		  "0001110" when MUXOUT = "1111" else
		  "1111111";

end Behavioral;
