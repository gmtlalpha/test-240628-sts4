import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Link } from 'react-router-dom';
import { NavLink } from "react-router-dom";
const Header = () => {
  return (
    <>
      <Navbar bg="light" data-bs-theme="light">
        <Container>
          <Nav className="me-auto">
            <Link to="/" className="nav-link">
              HOME
            </Link>
            <Link to="/saveForm" className="nav-link">
              SAVE
            </Link>
            <Link to="/joinForm" className="nav-link">
              JOIN
            </Link>
            <Link to="/loginForm" className="nav-link">
              LOGIN
            </Link>
          </Nav>
          <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="outline-success">Search</Button>
          </Form>
        </Container>
      </Navbar>
    </>
  );
};
export default Header;
