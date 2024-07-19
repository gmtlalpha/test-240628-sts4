import { useRef } from "react";

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
