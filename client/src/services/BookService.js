
const API_URL = 'http://localhost:8080/book';

export const getAllBooks = async () => {
  const res = await fetch(`${API_URL}/getAll`);
  return res.json();
};

export const getBookById = async (id) => {
  const res = await fetch(`${API_URL}/getByIb/${id}`);
  return res.json();
};

export const addBook = async (book) => {
  const res = await fetch(`${API_URL}/add`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(book)
  });
  return res.json();
};

export const updateBook = async (id, book) => {
  const res = await fetch(`${API_URL}/update/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(book)
  });
  return res.json();
};

export const getBookByName = async (name) => {
  const res = await fetch(`${API_URL}/getByName/${name}`);
  return res.json();
};

export const getBookByPublishDate = async (year) => {
  const res = await fetch(`${API_URL}/getByPublishDate/${year}`);
  return res.json();
};
