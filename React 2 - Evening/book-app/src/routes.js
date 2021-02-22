import React from 'react'
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import Book from './components/Book'
import Header from './components/Book'
import SearchBar from './components/SearchBar'
import App from './components/App'

export default function Routes() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact component={App}></Route>
        <Route path="/book/:id" exact component={App}></Route>
      </Switch>
    </BrowserRouter>
  )
}