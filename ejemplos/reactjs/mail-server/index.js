const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const mailServer = require('./data/builder');

const app = express();
app.use(cors());
app.use(bodyParser.json());

app.post('/login', (req, res) => {
  res.send(mailServer.loginUser(req.body.email, req.body.password));
});

app.post('/register', (req, res) => {
  res.send(mailServer.register(req.body));
});

app.get('/:email', (req, res) => {
  res.send(mailServer.getUser(req.params.email));
});

app.post('/sendMail', (req, res) => {
  res.send(mailServer.sendMail(req.body.emailFrom, req.body.emailTo, req.body.mail));
});

app.post('/readMails', (req, res) => {
  res.send(mailServer.markRead(req.body.email, req.body.mailsIds));
});

app.post('/unreadMails', (req, res) => {
  res.send(mailServer.markUnread(req.body.email, req.body.mailsIds));
});

app.post('/favMail', (req, res) => {
  res.send(mailServer.favMail(req.body.email, req.body.mailId));
});

app.delete('/delete', (req, res) => {
  res.send(mailServer.deleteMail(req.body.email, req.body.mailId));
});

app.listen(3003, () => {
  console.log('Example app listening on port 3003!');
});
