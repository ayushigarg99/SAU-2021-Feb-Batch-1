import React, { useState } from 'react';
import Header from './Header'
import Book from "./Book"
import SearchBar from './SearchBar'
import Button from '@material-ui/core/Button';
import '../index.css'




function App() {

    const [book,setBook] = useState([
        {
            title:"The Kite Runner",
            author:"Khaled Hosseini",
            content:"The story is set against a backdrop of tumultuousgees an regime."
        },
        {
            title:"One Hundred Years of Solitude",
            author:"Gabriel García Márquez",
            content:"The novel tells the story of seven generations of the Buendía family"
        },
        {
            title:"A Passage to India",
            author:"E.M. Forster",
            content:"The book was published in 1924"
        }
    ]);

    const [clicked,setClicked] = useState(false);

    const [searchvalue, setSearchValue] = useState("");


    function handleClick(){
        setClicked(!clicked);
    }

    function handleChange(event){
        const value = event.target.value;
        setSearchValue(value);
    }

    const [result,setResult] = useState([]);
    const [found,setFound] = useState(false);

    function searchBook(searchValue){
        const searchedBook = book.filter((bookItem)=>{
            return bookItem.title === searchValue;
        });
        if(searchBook!=null){
            setFound(true);
        }
        //console.log(searchedBook[0].title);
        setResult(searchedBook);
    }

    const divstyle = {
        display: 'flex',
        justifyContent: 'center'

    }

    return (
        <div className={divstyle}>
        <Header />
        <button onClick={handleClick}>Click to show all books</button>
        <br />
        <br />
        <SearchBar onSearch={searchBook} />
        {setFound && result.map((bookItem,index) => {
            return (
                <Book 
                id={index}
                title={bookItem.title}
                author={bookItem.author}
                content={bookItem.content}
                />
            )
        })}
        <br />
        <br />
        {clicked ? book.map((bookItem) => {
            return (
                <Book 
                title={bookItem.title}
                author={bookItem.author}
                content={bookItem.content}
                />
            )
        }) : null}

        </div>

    );
};

export default App;