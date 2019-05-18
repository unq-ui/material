const axios = require('axios');
const promise = axios.get('https://randomuser.me/api/')
  .then(request => console.log(request.data))
  .then(() => 1)
  .catch(error => console.log('Error', error))
console.log("despues del llamado -> ", promise)

setTimeout(() => console.log('Tiene que ser 1 =>', promise), 1500)