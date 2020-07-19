entity myvend is
Port ( clock : in  STD_LOGIC;
       reset : in  STD_LOGIC;
      money : in  STD_LOGIC_VECTOR (1 downto 0);
      vend : out  STD_LOGIC);
end myvend;architecture moore of myvend istype states is
  (zerocents, fivecents, tencents, fifteencents); 
signal currentstate: states; beginprocess(clock,reset)

begin  if reset='1' then  currentstate <= zerocents;
elsif(clock'event and clock='1') then

case currentstate is
  when zerocents =>
    if money="00" then currentstate <= zerocents; 
    elsif money="01" then currentstate <= fivecents;
    elsif money="10" then currentstate <= tencents;
    elsif money="11" then currentstate <= zerocents;
    end if;		
  when fivecents =>
    if money="00" then currentstate <= fivecents;
    elsif money="01" then currentstate <= tencents; 
    elsif money="10" then currentstate <= fifteencents; 
    elsif money="11" then currentstate <= fifteencents; 
    end if; 		
  when tencents =>
    if money ="00" then currentstate <= tencents; 
    elsif money="01" then currentstate <= fifteencents;
    elsif money="10" then currentstate <= fifteencents; 
    elsif money="11" then currentstate <= fifteencents;
    end if;		
  when fifteencents =>
    if money="00" then currentstate <= fifteencents; 
    elsif money="01" then currentstate <= fifteencents; 
    elsif money="10" then currentstate <= fifteencents; 
    elsif money="11" then currentstate <= fifteencents; 
    end if; 		
  end case; 
  end if; 

end process;	
process(currentstate)begincase(currentstate)
iswhen zerocents => vend <= '0';
when fivecents => vend <= '0';
when tencents => vend <= '0';
when fifteencents => vend <= '1'; 
end case; 
end process; 
end moore;
