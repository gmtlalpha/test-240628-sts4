import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import { useParams } from 'react-router-dom';
const Detail = (props) => {
//   const id = props.match.params.id;
let params = useParams();
var id = params.id;
  const [wish, setWish] = useState({
    id: '',
    title: '',
    info: '',
  });
  useEffect(() => {
    fetch('http://localhost:8080/wish/' + id)
      .then((res) => res.json())
      .then((res) => {
        setWish(res);
      });
  }, []);

  const deleteWish = (id) => {
    // e.preventDefault();
    fetch('http://localhost:8080/wish', {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
      },
      body: JSON.stringify(wish),
    })
      .then((res) => {
        return res.text();
      })
      .then((res) => {
        if (res === 'ok') {
          try {
            props.history.push('/');
          } catch (error) {
            console.log(error);
          }
        } else {
          alert('deleting wish error');
        }
      });
  };
  const updateWish = (id = () => {
    props.history.push('/updateForm/' + id);
  });
  return (
    <div>
      <h1>Wish LIST in Detail</h1>
      <Button onClick={() => updateWish(wish.id)}>update</Button>
      <Button onClick={() => deleteWish(wish.id)}>delete</Button>
      <br></br>
      <h3>{wish.title}</h3>
      <h3>{wish.info}</h3>
    </div>
  );
};

export default Detail;
