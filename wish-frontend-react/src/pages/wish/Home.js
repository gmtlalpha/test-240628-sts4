import React, { useEffect, useState } from 'react';
import WishItem from '../../components/WishItem';

const Home = () => {
  const [wish, setWish] = useState([]);

  //run once, run when update
  useEffect(() => {
    fetch('http://localhost:8080/wish', {
      method: 'GET',
    })
      .then((res) => res.json())
      .then((data) => setWish(data));
  }, []);

  return (
    <div>
      {wish.map((wish) => (
        <WishItem key={wish.id} wish={wish} />
      ))}
    </div>
  );
};

export default Home;
