
import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import BookManager from './components/Book/BookManager';
import CustomerManager from './components/Customer/CustomerManager';
import LendingManager from './components/Lending/LendingManager';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <nav>
          <Link to="/books">ספרים</Link>
          <Link to="/customers">לקוחות</Link>
          <Link to="/lendings">השאלות</Link>
        </nav>
        <Routes>
          <Route path="/books" element={<BookManager />} />
          <Route path="/customers" element={<CustomerManager />} />
          <Route path="/lendings" element={<LendingManager />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
