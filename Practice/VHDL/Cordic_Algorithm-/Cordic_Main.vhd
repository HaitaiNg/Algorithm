library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL; 
use IEEE.NUMERIC_STD.ALL; 
use IEEE.STD_LOGIC_UNSIGNED.ALL; 

entity cordic_main is
	PORT( CLK : in  STD_LOGIC; -- 100 Mhz Clock 
         RST : in  STD_LOGIC;  -- Reset --- P18 
			sine_select : in STD_LOGIC; -- calculate the sine or cosine output?
			angle: in STD_LOGIC_VECTOR(11 downto 0); 
			is_neg: in STD_LOGIC; -- negative value ?  
			calc_en: in STD_LOGIC; -- calculate? 
			out_bin: out STD_LOGIC_VECTOR(16 downto 0); --output value 
			out_en: out STD_LOGIC; -- when to convert the BCD angle into 7 segment display format 
			neg_result: out STD_LOGIC);  -- print out a negative value? 
end cordic_main;

architecture Behavioral of cordic_main is
signal BCD_conversion: integer:= 0;  -- the integer 
signal cos_neg: std_logic := '0'; -- assume positive 
signal sine_neg: std_logic := '0'; --assume positive 
signal neg: std_logic := '0'; 
signal an_state: integer := 0; -- used to handle shifts/ states for the device
signal BCD_Binary: std_logic_vector(16 downto 0):= "00000000000000000"; 
signal init_done: std_logic := '0'; 

type TRIG_TABLE is array (0 to 17) of std_logic_vector(0 to 16);
constant LUT_table: TRIG_TABLE:= ("00010110100000000", "00001101010010000","00000111000001001","00000011100100000",
	"00000001110010011", "00000000111001010", "00000000011100101", "00000000001110010", "00000000000111001","00000000000011100",
	"00000000000001110","00000000000000111","00000000000000011","00000000000000001","00000000000000000",
	"00000000000000000","00000000000000000", "00000000000000000");
	
signal a: std_logic_vector(8 downto 0) := "000000000"; 
signal shift_count: integer range 0 to 20; -- shift count 
signal i: integer range 0 to 20 ; 
signal x: std_logic_vector(16 downto 0) := "01001101101110001"; 
signal dx: std_logic_vector(16 downto 0):= "00000000000000000";  
signal y: std_logic_vector(16 downto 0) := "00000000000000000"; 
signal dy: std_logic_vector(16 downto 0):= "00000000000000000";  
signal da: std_logic_vector(16 downto 0):= "00000000000000000";  

signal en: std_logic := '0'; 


begin
process(CLK, RST, calc_en, neg)
begin
	if( RST = '1') then -- If reset is high, reset everything 
		out_bin <= "00000000000000000"; 
		out_en <= '0'; 
		neg_result <= '0'; 
		an_state <= 0;
		shift_count <= 0;
		i <= 0;
		dx <= "00000000000000000";
		dy <= "00000000000000000";
		x <= "01001101101110001";
		y <= "00000000000000000";
	--end if; 
	
	elsif( CLK'event and CLK = '1' and calc_en = '1') then
	
	case an_state is
		when 0 => 
			-- convert 12 bit binary value into a decimal 
				BCD_conversion <= (conv_integer(angle(11 downto 8)))*100 + (conv_integer(angle(7 downto 4)))*10 + (conv_integer(angle(3 downto 0)))*1; 
				an_state <= 1; -- move to the next state  		
		--end if; 
		  
		
		when 1 => -- determine the quadrant 
			-- first quadrant
			if(BCD_conversion > 0) and (BCD_conversion < 90) then
				if(is_neg = '1') then 
					sine_neg <= '1';
					cos_neg <= '0'; 
				else
					sine_neg <= '0'; 
					cos_neg <= '0'; 
				end if; 
			end if; 
		
			-- second quadrant
			if((BCD_conversion > 90) and (BCD_conversion <= 180)) then
					BCD_conversion <= 180 - BCD_conversion; 
					if (is_neg = '1') then -- if neg_sign 1 means negative
						sine_neg <= '1';
						cos_neg <= '1';
					else
						sine_neg <= '0';
						cos_neg <= '1';
					end if;			
			end if;
			
			-- third quadrant
			if((BCD_conversion > 180) and (BCD_conversion <= 270)) then
					BCD_conversion <= BCD_conversion - 180;  
					if (is_neg = '1') then -- if neg_sign 1 means negative
						sine_neg <= '0';
						cos_neg <= '1';
					else
						sine_neg <= '1';
						cos_neg <= '1';
					end if;
			end if; 	
			
			-- fourth quadrant 
			if((BCD_conversion > 270) and (BCD_conversion <= 360)) then
					BCD_conversion <= 360 - BCD_conversion;  
					if (is_neg = '1') then -- if neg_sign 1 means negative
						sine_neg <= '0';
						cos_neg <= '0';
					else
						sine_neg <= '1';
						cos_neg <= '0';
					end if; 
			end if; 
					
			an_state <= 2; -- move to the next state 
				
		when 2 =>
				-- convert the BCD value into a 9 bit then concatenate to a 17 bit 
				BCD_Binary <= (conv_std_logic_vector(BCD_conversion,9)) & "00000000"; 
				init_done <= '1'; 
				an_state <= 3; -- move to the next state 
		
		when 3 => --- S1 (shift) 
				if(init_done = '1') then
					dx <= x;
					dy <= y; 				
				end if; 
				an_state <= 4;
				
		when 4 => -- Internal loop dx = x / 2^i, dy = y / 2^i 
				if(shift_count < i) then
					dx <= '0' & dx(16 downto 1); 
					dy <= '0' & dy(16 downto 1); 
					 
					shift_count <= shift_count + 1;
					an_state <= 4;
				else
				da <= LUT_TABLE(i);
					an_state <= 5; 
				end if; 
				 
		when 5 => 
				if( BCD_Binary(16) = '0') then 
					x <= x - dy;
					BCD_Binary <= BCD_Binary - da; 
					y <= y + dx;					
				else 
					x <= x + dy; 
					BCD_Binary <= BCD_Binary + da; 
					y <= y - dx;
				end if; 
				
				if( i = 17) then 
					an_state <= 6; 
				else 
					shift_count <= 0;
					i <= i + 1; 
					an_state <= 3; 
				end if; 
				
		when 6 => 
				out_en <= '1'; 
				
				if(sine_select <= '0') then 
					neg <= sine_neg; 
					out_bin <= y;
				else 
					neg <= cos_neg; 
					out_bin <= x; 
				end if; 
				an_state <= 6;
			
		
	when others => 
	         an_state <= 0; 
			
	end case;	
	end if; 
   neg_result <= neg; 
				
end process; 
end Behavioral;

