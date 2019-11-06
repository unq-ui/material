import axios from 'axios';

axios.defaults.baseURL = "http://localhost:7000";
axios.defaults.timeout = 10000; // 10s
axios.defaults.headers.post['Content-Type'] = 'application/json';

const request = (type, path, body) =>
  axios
    .request({ url: path, method: type, data: body })
    .then(response => response.data)
    .catch(error => {
        console.log(error.toJSON());
        Promise.reject(error); // equivalente: try {...} catch (e: Exception) { throw Exception(error) }
      });

const api = {
    getTweets: () => request('get', '/tweets'),
    createTweet: ({ username, tweet }) => request('post',
      `/tweets/${username}`,
      { text: tweet }
    )
}

export default api;
