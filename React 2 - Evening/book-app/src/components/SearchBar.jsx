import React, { useState } from 'react';

const buttonstyle = {
    margin: '20px',
  border: '2px solid black'
}

function SearchBar(props){

    const [keyword,setKeyword] = useState("");

    function handleSearch(event) {
        props.onSearch(keyword);
    }
    const BarStyling = {width:"20rem",background:"#F2F1F9", border:"2px solid black", padding:"0.5rem"}
    return (
        <div>

        <input 
         style={BarStyling}
         key="random1"
         value={keyword}
         placeholder={"search Book..."}
         onChange={(e) => setKeyword(e.target.value)}
        />
        <br />
        <button style={buttonstyle} onClick={handleSearch}>Search</button>

        </div>    
        
      );
    
}
export default SearchBar;
