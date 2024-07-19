import React from 'react';
import { Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
const WishItem = (props) => {
  const { id, title, info } = props.wish;
  return (
    <Card>
      <Card.Body>
        <Card.Title>{title}</Card.Title>
        <Link to={'/wish/' + id} className="btn btn-primary">
          seeDetail
        </Link>
      </Card.Body>
    </Card>
  );
};

export default WishItem;
