import React from 'react';
import ReactDOM from 'react-dom';
import '../src/index.js';
import ClassComponent from './Components/ClassComponents.jsx';
import FunctionComponent from './Components/FunctionComponent.jsx';
import App from './Container/App.js';


ReactDOM.render(
  <React.StrictMode>
    <App />
    <ClassComponent/>
    <FunctionComponent/>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals

