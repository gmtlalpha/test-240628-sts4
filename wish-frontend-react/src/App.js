import React, { useEffect } from 'react';
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
  useEffect(() => {
    const onUnload = (ev) => {

      window.dummyClearAU()
      window.dummyClearBBC()
      console.log(123123123)
      console.log(123123123)
      console.log(123123123)
      console.log(123123123)
      console.log(123123123)
      console.log(123123123)
      console.log(123123123);
      var ret = window.confirm('work will not be saved. Do you want to Continue ?');
        if( ret == true ){

        }else{
          return false
        }
    };

    window.addEventListener("beforeunload", onUnload);

    return () => {
      window.removeEventListener("beforeunload", onUnload);
    };
  }, []);

  const isAU = false;
  const isBBC = false;
  const isETC = true;
  if(isAU){
    window.open("http://localhost:8080/dummyBBC",'dummyBBC')
  }
  if(isBBC){
    window.open("http://localhost:8080/dummyBBC",'dummyBBC')
  }
  const closeButton =()=>{
    window.dummyClearAU()
    window.dummyClearBBC()
  }
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
        <iframe title="AAAAAA" name="dummyAU" src="" hidden/>
        <iframe name="dummyBBC" src="" hidden/>

      <button onClick={closeButton}>closeButton</button>
    </div>
  );
}

export default App;
