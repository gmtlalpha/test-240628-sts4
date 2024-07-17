import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { useNavigate, useParams } from 'react-router-dom';

const SaveForm = (props) => {
  const navigate = useNavigate();
  const [wish, setWish] = useState([
    {
      title: '',
      info: '',
    },
  ]);
  const changeValue = (e) => {
    setWish({ ...wish, [e.target.name]: e.target.value });
  };
  const submitWish = (e) => {
    e.preventDefault();
    fetch('http://localhost:8080/wish', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
      },
      body: JSON.stringify(wish),
    })
      .then((res) => {
        if (res.status === 201) {
          return res.json();
        } else {
          return res.json();
        }
      })
      .then((res) => {
        if (res !== null) {
          try {
            // props.history.push('/');
            navigate('/');
          } catch (error) {
            console.log(error);
          }
        } else {
          alert('saving wish error');
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <Form onSubmit={submitWish}>
      <Form.Group as={Row} className="mb-3" controlId="formHorizontalEmail">
        <Form.Label column sm={2}>
          title
        </Form.Label>
        <Col sm={10}>
          <Form.Control
            type="title"
            placeholder="title"
            onChange={changeValue}
            name="title"
          />
        </Col>
      </Form.Group>

      <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword">
        <Form.Label column sm={2}>
          info
        </Form.Label>
        <Col sm={10}>
          <Form.Control
            type="info"
            placeholder="info"
            onChange={changeValue}
            name="info"
          />
        </Col>
      </Form.Group>

      <Form.Group as={Row} className="mb-3">
        <Col sm={{ span: 10, offset: 2 }}>
          <Button type="submit">save</Button>
        </Col>
      </Form.Group>
    </Form>
  );
};

export default SaveForm;
