import sys
import spotipy
import spotipy.util as util


def iterateThroughListContents( listInput):
    if(len(listInput) > 0):
        listOfContents = []  
        for content in listInput:
            if "name" in content.keys():
                listOfContents.append(content["name"].encode('ascii', 'ignore'))
        return str(listOfContents)
    return str(listInput[0])



if len(sys.argv) > 1:
    username = sys.argv[1]
else:
    print("Usage: %s username" % (sys.argv[0],))
    sys.exit()

scope = 'user-top-read'
token = util.prompt_for_user_token(username, scope)

if token:
    sp = spotipy.Spotify(auth=token)
    sp.trace = False
    ranges = ['short_term', 'medium_term', 'long_term']

    ''' 
    #Get the list of the top tracks for a user 
    for range in ranges:
        print("range:", range)
        results = sp.current_user_top_tracks(time_range=range, limit=50)
        for i, item in enumerate(results['items']):
            artist, songName, spotifyURL = iterateThroughListContents(item['artists']), item["name"], item["external_urls"]["spotify"]
            print(songName + " :: " + artist + " :: " + spotifyURL)
        print("\n") '''
        
    genreTypesAndFrequency = {} 
    
    #Get the list of the top artists for a user 
    
    for range in ranges:
        print("range:", range)
        results = sp.current_user_top_artists(time_range=range, limit=50)
        for i, item in enumerate(results['items']):
            artist, genres, spotifyURL = item['name'],  [ f.encode('ascii', 'ignore') for f in item['genres']], item['external_urls']['spotify']
            print(artist + " :: " + str(genres))

            for genre in genres: 
                if genre in genreTypesAndFrequency.keys():
                    genreTypesAndFrequency[genre] +=1 
                else:
                    genreTypesAndFrequency[genre] = 1 

        print("\n")  
    print("\n")
    for k in sorted(genreTypesAndFrequency.keys()):
        print(k + " " + str(genreTypesAndFrequency[k]))


else:
    print("Can't get token for", username)