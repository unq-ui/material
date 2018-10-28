const assert = require('assert');
const MailServer = require('../src/mailServer');

const newUserA = { email: 'a@gmail.com', password: 'a', profile: { name: 'a', image: '...' } };
const newUserB = { email: 'b@gmail.com', password: 'b', profile: { name: 'b', image: '...' } };
const mail = { subject: 'hola', body: 'mundo' };

describe('MailServer', () => {
  describe('#register()', () => {
    it('should add new user', () => {
      const mailServer = new MailServer([]);
      mailServer.register(newUserA);
      assert.equal(true, mailServer.loginUser('a@gmail.com', 'a'));
    });
    it('shouldnt add 2 times the same user', () => {
      const mailServer = new MailServer([]);
      mailServer.register(newUserA);
      assert.throws(() => mailServer.register(newUserA));
    });
  });

  describe('#loginUser()', () => {
    it('should be true when user exist', () => {
      const mailServer = new MailServer([]);
      mailServer.register(newUserA);
      assert.equal(true, mailServer.loginUser('a@gmail.com', 'a'));
    });
    it('should be false when user not exist', () => {
      const mailServer = new MailServer([]);
      assert.equal(false, mailServer.loginUser('a@gmail.com', 'a'));
    });
  });

  describe('#getUser()', () => {
    it('should be throw exception when user not exist', () => {
      const mailServer = new MailServer([]);
      assert.throws(() => mailServer.getUser('a@gmail.com'));
    });
    it('should be return the user', () => {
      const mailServer = new MailServer([]);
      mailServer.register(newUserA);
      const user = mailServer.getUser('a@gmail.com');
      assert.equal(user.email, newUserA.email);
      assert.equal(user.password, undefined);
      assert.equal(user.profile.name, newUserA.profile.name);
      assert.equal(user.profile.image, newUserA.profile.image);
      assert.equal(user.mails.length, 0);
      assert.equal(user.sendedMails.length, 0);
    });
  });

  describe('#sendMail', () => {
    it('should have one mail', () => {
      const mailServer = new MailServer([]);
      mailServer.register(newUserA);
      mailServer.register(newUserB);
      mailServer.sendMail('a@gmail.com', 'b@gmail.com', mail);
      const userA = mailServer.getUser('a@gmail.com');
      const userB = mailServer.getUser('b@gmail.com');
      assert.equal(0, userA.mails.length);
      assert.equal(1, userA.sendedMails.length);
      assert.equal(1, userB.mails.length);
      assert.equal(0, userB.sendedMails.length);
      assert.equal('hola', userB.mails[0].subject);
      assert.equal('mundo', userB.mails[0].body);
    });
  });

  describe('#markRead', () => {
    it('should read mail', () => {
      const mailServer = new MailServer([]);
      mailServer.register(newUserA);
      mailServer.register(newUserB);
      mailServer.sendMail('a@gmail.com', 'b@gmail.com', mail);
      const userB = mailServer.getUser('b@gmail.com');
      assert.equal(1, userB.mails.length);
      assert.equal(false, userB.mails[0].read);
      mailServer.markRead('b@gmail.com', ['1']);
      assert.equal(true, userB.mails[0].read);
    });
  });

  describe('#markUnread', () => {
    it('should unread mail', () => {
      const mailServer = new MailServer([]);
      mailServer.register(newUserA);
      mailServer.register(newUserB);
      mailServer.sendMail('a@gmail.com', 'b@gmail.com', mail);
      const userB = mailServer.getUser('b@gmail.com');
      assert.equal(1, userB.mails.length);
      assert.equal(false, userB.mails[0].read);
      mailServer.markRead('b@gmail.com', ['1']);
      assert.equal(true, userB.mails[0].read);
      mailServer.markUnread('b@gmail.com', ['1']);
      assert.equal(false, userB.mails[0].read);
    });
  });

  describe('#deleteMail', () => {
    it('should have 0 mails', () => {
      const mailServer = new MailServer([]);
      mailServer.register(newUserA);
      mailServer.register(newUserB);
      mailServer.sendMail('a@gmail.com', 'b@gmail.com', mail);
      let userB = mailServer.getUser('b@gmail.com');
      assert.equal(1, userB.mails.length);
      mailServer.deleteMail('b@gmail.com', '1');
      userB = mailServer.getUser('b@gmail.com');
      assert.equal(0, userB.mails.length);
    });
  });

  describe('#favMail', () => {
    it('should change to fav 1 time its true', () => {
      const mailServer = new MailServer([]);
      mailServer.register(newUserA);
      mailServer.register(newUserB);
      mailServer.sendMail('a@gmail.com', 'b@gmail.com', mail);
      const userB = mailServer.getUser('b@gmail.com');
      assert.equal(1, userB.mails.length);
      assert.equal(false, userB.mails[0].fav);
      mailServer.favMail('b@gmail.com', '1');
      assert.equal(true, userB.mails[0].fav);
    });
    it('should change to fav 2 time its false', () => {
      const mailServer = new MailServer([]);
      mailServer.register(newUserA);
      mailServer.register(newUserB);
      mailServer.sendMail('a@gmail.com', 'b@gmail.com', mail);
      const userB = mailServer.getUser('b@gmail.com');
      assert.equal(1, userB.mails.length);
      assert.equal(false, userB.mails[0].fav);
      mailServer.favMail('b@gmail.com', '1');
      assert.equal(true, userB.mails[0].fav);
      mailServer.favMail('b@gmail.com', '1');
      assert.equal(false, userB.mails[0].fav);
    });
  });
});
