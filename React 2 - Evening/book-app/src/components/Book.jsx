import React, {useState} from 'react';

function Book(props){

    const [isexpand, setIsexpand] = useState(false);

    function expand() {
        setIsexpand(!isexpand);
      }

    return (
        <div className="book" onClick={expand}>
          <h1>{props.title}</h1>
            {isexpand && 
            <div>
            <p>{props.author}</p>
            <br />
            <p>{props.content}</p>
            </div>
            }  
        </div>
      );
}

export default Book;