
def string_scramble(stringOne, stringTwo):
	stringOne = stringOne.lower()
	stringTwo = stringTwo.lower()
	characterMapForStringOne = set()
	for character in stringOne:
		characterMapForStringOne.add(character)
	returnSet = set()
	for character in stringTwo:
		if character in characterMapForStringOne:
			returnSet.add(character)
	return list(returnSet)

print(string_scramble("GraSS", "grilled cheese"))
