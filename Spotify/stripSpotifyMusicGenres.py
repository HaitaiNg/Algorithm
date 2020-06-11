'''
Refresh Date: 06.09.20 
Author: Haitai Ng 

There are a total of 4423 genres available via Spotify. I have categorized 
a total of 3207 into 86 parent genres. Currently there are 
1216 genres that are not categorized.

Future Work: I could possibly convert this to a web api
User passes in a song, and the corresponding genre returns. 

Future functions / Sub-routines 
getListOfMainGenres() // return List []  
getMapOfGenres() // return hash map {} (dictionary {}) 
getTotalAmountOfGenres()  //return int 
''' 

mapOfGenres = {} 
ListOfMainGenres = ['acoustic', 'afro', 'alternative', 'ambient', 'american', 
'australian', 'belgian', 'blues', 'brazilian', 'british', 'canadian', 'chill', 
'chinese', 'choir', 'christian', 'classic', 'classical', 'country', 'cumbia', 
'dark', 'deep', 'disco', 'dubstep', 'dutch', 'edm', 'electro', 'electronic', 
'experimental', 'finnish', 'folclor', 'folk', 'french', 'funk', 'german', 
'hard', 'hip hop', 'historic', 'indie', 'indonesian', 'instrumental', 'irish',
 'italian', 'japanese', 'jazz', 'korean', 'latin', 'lo-fi', 'melodic', 'metal',
  'mexic', 'minimal', 'modern', 'musica', 'musica', 'musique', 'muzica', 'neo', 
  'new', 'nordic', 'norwegian', 'old school', 'orchestra', 'polish', 'pop', 'post', 
  'progressive', 'punk', 'r&b', 'rap', 'reggae', 'rock', 'russian', 'salsa', 'scottish', 
  'ska', 'sound', 'south african', 'spanish', 'swedish', 'taiwanese', 'techno', 'trap', 
  'uk', 'vintage', 'vintange', 'yoga']


for genre in ListOfMainGenres:
    mapOfGenres[genre] = [] 

fileOpen = open("SpotifyMusicGenres.txt", "r") 
numberOfGenresAdded = 0 
unfilteredList = [] 
numberOfGenres = 0 
for genre in fileOpen.readlines():
    numberOfGenres += 1 
    parsedGenre = ' '.join(genre.split()[2:])
    added = False 
    for k, v in mapOfGenres.items():   
        if k in parsedGenre:
            v.append(parsedGenre) 
            added = True 
    if(added):
        numberOfGenresAdded += 1 
    else:
        unfilteredList.append(parsedGenre) 

print("Number of Genres")
print(numberOfGenresAdded)
print("Total Number Of Genres")
print(numberOfGenres)
print(len(ListOfMainGenres)) #
    
