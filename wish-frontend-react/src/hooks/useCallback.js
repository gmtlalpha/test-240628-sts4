import { useCallback } from "react";

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
