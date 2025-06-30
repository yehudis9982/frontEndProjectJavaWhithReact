
import React, { useState, useEffect } from 'react';
import {
  getAllBooks,
  getBookById,
  addBook,
  updateBook,
  getBookByName,
  getBookByPublishDate
} from '../../services/BookService';

function BookManager() {
  const [books, setBooks] = useState([]);
  const [form, setForm] = useState({ bookId: '', bookName: '', author: '', releaseDate: '' });
  const [searchYear, setSearchYear] = useState('');
  const [searchName, setSearchName] = useState('');
  const[searchId,setSearchId]=useState('');

  useEffect(() => {
    fetchBooks();
  }, []);

  const fetchBooks = async () => {
    const data = await getAllBooks();
    setBooks(data);
  };

  const handleInputChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleAddBook = async () => {
    if (!form.bookName || !form.author || !form.releaseDate) {
      alert('אנא מלא את כל השדות');
      return;
    }
    await addBook(form);
    fetchBooks();
    setForm({ bookId: '', bookName: '', author: '', releaseDate: '' });
  };

  const handleUpdateBook = async () => {
    if (!form.bookId) {
      alert('יש להזין מזהה ספר לעדכון');
      return;
    }
    await updateBook(form.bookId, form);
    fetchBooks();
  };

  const handleSearchByYear = async () => {
    const data = await getBookByPublishDate(searchYear);
    setBooks(data);
  };

  const handleSearchByName = async () => {
    const book = await getBookByName(searchName);
    setBooks(book ? [book] : []);
  };
   const handleSearchById = async () => {
    const book = await getBookById(searchId);
    setBooks(book ? [book] : []);
  };

  return (
    <div className="container">
      <h2>ניהול ספרים</h2>
      <form>
        <input type="text" name="bookId" placeholder="מזהה (רק לעדכון)" value={form.bookId} onChange={handleInputChange} />
        <input type="text" name="bookName" placeholder="שם הספר" value={form.bookName} onChange={handleInputChange} />
        <input type="text" name="author" placeholder="מחבר" value={form.author} onChange={handleInputChange} />
              <input type="date" name="releaseDate" placeholder="תאריך החזרה" value={form.releaseDate} onChange={handleInputChange} />
      
        <button type="button" onClick={handleAddBook}>הוסף ספר</button>
        <button type="button" onClick={handleUpdateBook}>עדכן ספר</button>
      </form>

      <div style={{ marginTop: '2em' }}>
        <input type="text" placeholder="חפש לפי שם" value={searchName} onChange={(e) => setSearchName(e.target.value)} />
        <button onClick={handleSearchByName}>חפש לפי שם</button>

        <input type="number" placeholder="חפש לפי שנה" value={searchYear} onChange={(e) => setSearchYear(e.target.value)} />
        <button onClick={handleSearchByYear}>חפש לפי שנה</button>
         <input type="number" placeholder="חפש לפי קוד ספר" value={searchId} onChange={(e) => setSearchId(e.target.value)} />
        <button onClick={handleSearchById}>חפש לפי קוד ספר</button>
      </div>

      <table border="1" style={{ marginTop: '2em', width: '100%', textAlign: 'center' }}>
        <thead>
          <tr>
            <th>מזהה</th>
            <th>שם</th>
            <th>מחבר</th>
            <th>שנת פרסום</th>
          </tr>
        </thead>
        <tbody>
          {books.map((b) => (
            <tr key={b.bookId}>
              <td>{b.bookId}</td>
              <td>{b.bookName}</td>
              <td>{b.author}</td>
              <td>{b.releaseDate}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default BookManager;
