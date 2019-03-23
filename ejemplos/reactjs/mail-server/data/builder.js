const MailServer = require('../src/mailServer');
const users = require('./user.json');
const mails = require('./mails.json');

const emails = users.map(user => user.email);

const mailServer = new MailServer([]);
users.map(user => mailServer.register(user));

function selectUsers() {
  const index1 = Math.floor(Math.random() * emails.length);
  const index2 = Math.floor(Math.random() * emails.length);
  return [emails[index1], emails[index2]];
}

function selectMail() {
  const index = Math.floor(Math.random() * mails.length);
  return mails[index];
}

function sendRandomMails(times) {
  Array(times).fill().forEach(() => {
    mailServer.sendMail(...selectUsers(), selectMail());
  });
}

sendRandomMails(100);

module.exports = mailServer;
