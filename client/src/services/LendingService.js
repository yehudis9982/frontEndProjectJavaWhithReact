
const API_URL = 'http://localhost:8080/lending';

export const getAllLendings = async () => {
  const res = await fetch(`${API_URL}/getAll`);
  return res.json();
};

export const getAllLendingsById = async (id) => {
  const res = await fetch(`${API_URL}/getAllById/${id}`);
  return res.json();
};

export const addLending = async (lending) => {
  const res = await fetch(`${API_URL}/add`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(lending)
  });
  return res.json();
};

export const pay = async (id) => {
  const res = await fetch(`${API_URL}/pay/${id}`);
  return res.json();
};
export const returnBook1 = async (lendingId) => {
 
  const response = await fetch(`${API_URL}/returnBook/${lendingId}`, {
    method: 'PUT',
  });
  if (!response.ok) {
    throw new Error('שגיאה בעת החזרת הספר');
  }
};

