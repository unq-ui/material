const md5 = require('md5');

function findUserByProp(users, prop, value) {
  const findUser = users.find(user => user[prop] === value);
  if (findUser) return findUser;
  throw new Error('Usuario no existente');
}

function createMail(emailFrom, emailTo, id, mail) {
  return {
    id: id.toString(),
    from: emailFrom,
    to: emailTo,
    subject: mail.subject,
    body: mail.body,
    read: false,
    fav: false,
  };
}

class MailServer {
  constructor(users) {
    this.users = users;
    this.nextMailId = 1;
  }

  createUser(email, password, profile) {
    return {
      email,
      password: md5(password),
      profile,
      mails: [],
      sendedMails: [],
    };
  }

  getUser(email) {
    const user = { ...findUserByProp(this.users, 'email', email) };
    delete user.password;
    return user;
  }

  loginUser(email, password) {
    return !!this.users.find(user => user.email === email && user.password === md5(password));
  }

  register(newUser) {
    const findUser = this.users.find(user => user.email === newUser.email);
    if (findUser) {
      throw new Error('Usuario ya existente');
    }
    const user = this.createUser(newUser.email, newUser.password, newUser.profile);
    this.users.push(user);
    const userReturn = { ...user };
    delete userReturn.password;
    return userReturn;
  }

  sendMail(emailFrom, emailTo, mail) {
    const userFrom = findUserByProp(this.users, 'email', emailFrom);
    const userTo = findUserByProp(this.users, 'email', emailTo);
    const newMail = createMail(emailFrom, emailTo, this.nextMailId, mail);
    this.nextMailId += 1;
    userFrom.sendedMails.push(newMail);
    userTo.mails.push({ ...newMail });
  }

  markRead(email, mailsIds) {
    const user = findUserByProp(this.users, 'email', email);
    user.mails.forEach((mail) => {
      if (mailsIds.includes(mail.id)) mail.read = true;
    });
  }

  markUnread(email, mailsIds) {
    const user = findUserByProp(this.users, 'email', email);
    user.mails.forEach((mail) => {
      if (mailsIds.includes(mail.id)) mail.read = false;
    });
  }

  favMail(email, mailId) {
    const user = findUserByProp(this.users, 'email', email);
    user.mails.forEach((mail) => {
      if (mailId === mail.id) mail.fav = !mail.fav;
    });
  }

  deleteMail(email, mailId) {
    const user = findUserByProp(this.users, 'email', email);
    user.mails = user.mails.filter(mail => mailId !== mail.id);
  }
}

module.exports = MailServer;
