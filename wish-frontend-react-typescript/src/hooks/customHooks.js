import { useState, useEffect } from 'react';

/**
 * Custom Hooks
 */
const useFetch = (url) => {
  const [data, setData] = useState(null);

  useEffect(() => {
    fetch(url)
      .then((res) => res.json())
      .then((data) => setData(data));
  }, [url]);

  return [data];
};

const [data] = useFetch('https://jsonplaceholder.typicode.com/todos');
return (
  <>
    {data &&
      data.map((item) => {                
        return <p key={item.id}>{item.title}</p>;
      })}
  </>
);

