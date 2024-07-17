import React from 'react';
import { Container } from 'react-bootstrap';
import Header from './components/Header';
import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Home from './pages/wish/Home';
import SaveForm from './pages/wish/SaveForm';
import Detail from './pages/wish/Detail';
import LoginForm from './pages/user/LoginForm';
import JoinForm from './pages/user/JoinForm';
import UpdateForm from './pages/wish/UpdateForm';

function App() {
  return (
    <div>
      <Header />
      <Container>
        <Routes>
          <Route path="/" exact={true} Component={Home} />
          <Route path="/wish/:id" exact={true} Component={Detail} />
          <Route path="/saveForm" exact={true} Component={SaveForm} />
          <Route path="/updateForm/:id" exact={true} Component={UpdateForm} />
          <Route path="/loginForm" exact={true} Component={LoginForm} />
          <Route path="/joinForm" exact={true} Component={JoinForm} />
        </Routes>
      </Container>
    </div>
  );
}

export default App;
