const data = require('./data')

class Character {
  constructor(name, status, species, gender, image, locationName) {
    this.name = name;
    this.status = status;
    this.species = species;
    this.gender = gender;
    this.image = image;
    this.image = locationName;
  }
}

function getAllCharacters() {
  return data.map(character => {
    return new Character(character.name,
      character.status,
      character.species,
      character.gender,
      character.image,
      character.location.name
    )
  })
}

const allCharacters = getAllCharacters()
console.log(allCharacters);

function prettyPrint(allCharacters){
  allCharacters.forEach(ch => console.log(`name: ${ch.name} - species: ${ch.species}`))
}

prettyPrint(allCharacters);

function allCharactersBySpecies(allCharacters, species) {
  return allCharacters
    .filter(ch => ch.species === species)
    .map(ch => ch.name)
}

console.log(allCharactersBySpecies(allCharacters, 'Poopybutthole'))

function allCharactersBySpecies2(allCharacters, species) {
  return allCharacters
    .reduce((res, ch) => {
      if (ch.species === species) {
        res.push(ch.name)
      }
      return res;
    }, [])
}

console.log(allCharactersBySpecies2(allCharacters, 'Poopybutthole'))

function allCharactersBySpecies3(allCharacters, species) {
  return allCharacters
    .reduce((res, ch) => ch.species === species ? [...res, ch.name] : res, [])
}

console.log(allCharactersBySpecies3(allCharacters, 'Poopybutthole'))
