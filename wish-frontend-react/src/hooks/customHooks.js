
/**
 * Custom Hooks
 */
import { useState, useEffect } from 'react';
const useFetch = (url) => {
  const [data, setData] = useState(null);

  useEffect(() => {
    fetch(url)
      .then((res) => res.json())
      .then((data) => setData(data));
  }, [url]);

  return [data];
};
export default useFetch;
////////////////////
import useFetch from './useFetch';
const [data] = useFetch('https://jsonplaceholder.typicode.com/todos');
return (
  <>
    {data &&
      data.map((item) => {
        return <p key={item.id}>{item.title}</p>;
      })}
  </>
);
