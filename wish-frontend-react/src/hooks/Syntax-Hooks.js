/**
 * useState
 */
const [car, setCar] = useState({
  brand: 'Ford',
  model: 'Mustang',
  year: '1964',
  color: 'red',
});

const updateColor = () => {
  setCar((previousState) => {
    return { ...previousState, color: 'blue' };
  });
};

/**
 * useEffect(<function>, <dependency>)
 * side effects in your components. fetching data, directly updating the DOM, and timers.
 */
const [count, setCount] = useState(0);
useEffect(() => {
  setTimeout(() => {
    setCount((count) => count + 1);
  }, 1000);
}); //Runs on every render
// }, []); //Runs only on the first render
// }, [prop, state]); //Runs on the first render And any time any dependency value changes

/**
 * useContext
 * manage state globally.
 */
const UserContext = createContext();
const [user, setUser] = useState('Jesse Hall');
const user = useContext(UserContext);

/**
 * useRef
 * infinite loop since this Hook itself causes a re-render.
 * To avoid this, we can use the useRef Hook.
 */
const [inputValue, setInputValue] = useState('');
const count = useRef(0);

useEffect(() => {
  count.current = count.current + 1;
});

return (
  <>
    <input
      type="text"
      value={inputValue}
      onChange={(e) => setInputValue(e.target.value)}
    />
    <h1>Render Count: {count.current}</h1>
  </>
);

const inputElement = useRef();
const focusInput = () => {
  inputElement.current.focus();
};

return (
  <>
    <input type="text" ref={inputElement} />
    <button onClick={focusInput}>Focus Input</button>
  </>
);

/**
 * useReducer
 * custom useState Hook.
 */
const [todos, dispatch] = useReducer(reducer, initialTodos);

const handleComplete = (todo) => {
  dispatch({ type: 'COMPLETE', id: todo.id });
};
const initialTodos = [
  {
    id: 1,
    title: 'Todo 1',
    complete: false,
  },
  {
    id: 2,
    title: 'Todo 2',
    complete: false,
  },
];

const reducer = (state, action) => {
  switch (action.type) {
    case 'COMPLETE':
      return state.map((todo) => {
        if (todo.id === action.id) {
          return { ...todo, complete: !todo.complete };
        } else {
          return todo;
        }
      });
    default:
      return state;
  }
};
<input
  type="checkbox"
  checked={todo.complete}
  onChange={() => handleComplete(todo)}
/>;

/**
 * useCallback is to prevent a component from re-rendering unless its props have changed
 */
const [todos, setTodos] = useState([]);
const addTodo = useCallback(() => {
  setTodos((t) => [...t, 'New Todo']);
}, [todos]);
<Todos todos={todos} addTodo={addTodo} />;
const Todos = ({ todos, addTodo }) => {
  console.log('child render');
  return (
    <>
      <h2>My Todos</h2>
      {todos.map((todo, index) => {
        return <p key={index}>{todo}</p>;
      })}
      <button onClick={addTodo}>Add Todo</button>
    </>
  );
};
//Todos component will only re-render when the todos prop changes.

/**
 * useMemo
 * only runs when one of its dependencies update.
 * useMemo and useCallback Hooks are similar.
 * The main difference is that useMemo returns a memoized value
 * and useCallback returns a memoized function
 */
const calculation = expensiveCalculation(count);
const calculation = useMemo(() => expensiveCalculation(count), [count]);

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
