#Refresh Date: 06.09.20 
#There are a total of 4423 music genres 
mapOfGenres = {} 
ListOfMainGenres = ["alternative", "classical", "country", "edm", "electronic", 
    "funk", "hip hop", "indie", "jazz", "metal", "pop", "rap", "reggae", "rock", 
    "trap" ]  
    
for genre in ListOfMainGenres:
    mapOfGenres[genre] = [] 

numberOfGenresAdded = 0 
fileOpen = open("SpotifyMusicGenres.txt", "r") 
for genre in fileOpen.readlines():
    parsedGenre = ' '.join(genre.split()[2:])
    for k, v in mapOfGenres.items():   
        if k in parsedGenre:
            v.append(parsedGenre) 
            numberOfGenresAdded += 1
for k,v in mapOfGenres.items():
    print(str(k) + "  " + str(len(v)))
print("Number of Genres")
print(numberOfGenresAdded)
    
