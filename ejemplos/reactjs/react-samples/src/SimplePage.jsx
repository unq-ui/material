import React from 'react';
import { withRouter } from 'react-router';

const SimplePage = props => <div><h1>Hola {props.user.email}</h1></div>;

export default withRouter(SimplePage);
