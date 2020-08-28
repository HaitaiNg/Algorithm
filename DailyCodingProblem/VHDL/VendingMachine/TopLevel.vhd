entity top_level is
Port ( clock  : in  STD_LOGIC;
      money : in  STD_LOGIC_VECTOR (1 downto 0);
      reset  : in  STD_LOGIC;
      vend : out  STD_LOGIC);
end top_level;

architecture Behavioral of top_level
iscomponent clkdiv is
Port ( clk : in  STD_LOGIC;
      clkdiv : out  STD_LOGIC);end component;		 
      component debounce is
Port ( D_IN : in  STD_LOGIC;
      reset : in  STD_LOGIC;
      clock : in  STD_LOGIC;
      Q_OUT : out  STD_LOGIC);end component;
      component myvend is
Port ( clock : in  STD_LOGIC;
        reset : in  STD_LOGIC;
        money : in  STD_LOGIC_VECTOR (1 downto 0);
        vend : out  STD_LOGIC);end component; 			  			  
signal sysclk:
STD_LOGIC;
signal signalbounce: STD_LOGIC_VECTOR(1 downto 0);

begintheclkdiv: clkdiv port map(clock, sysclk); 
debounce1: debounce port map(money(0), reset, sysclk, signalbounce(0)); 
debounce2: debounce port map(money(1), reset, sysclk, signalbounce(1)); 
thevend: myvend port map( sysclk, reset, signalbounce, vend); 
end Behavioral;
