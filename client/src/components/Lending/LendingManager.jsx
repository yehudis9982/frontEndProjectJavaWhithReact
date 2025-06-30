import React, { useState, useEffect } from 'react';
import {
  getAllLendings,
  getAllLendingsById,
  addLending,
  pay,
  returnBook,
  returnBook1, // פונקציה חדשה שתצטרך להוסיף ב-LendingService
} from '../../services/LendingService';

function LendingManager() {
  const [lendings, setLendings] = useState([]);
  const [form, setForm] = useState({ lendingId: '', customerId: '', bookId: '', lendingDate: ''});
  const [searchId, setSearchId] = useState('');
  const [payId, setPayId] = useState('');
  const [payAmount, setPayAmount] = useState(null);

  useEffect(() => {
    fetchLendings();
  }, []);

  const fetchLendings = async () => {

    const data = await getAllLendings();
    setLendings(data);
  };

  const handleInputChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleAddLending = async () => {
    if (!form.customerId || !form.bookId || !form.lendingDate ) {
      alert('אנא מלא את כל השדות');
      return;
    }
    await addLending(form);
    fetchLendings();
    setForm({ lendingId: '', customerId: '', bookId: '', lendingDate: ''});
  };

  const handleSearchById = async () => {
    const data = await getAllLendingsById(searchId);
    setLendings(data);
  };

  const handlePay = async () => {
    const amount = await pay(payId);
    setPayAmount(amount);
    fetchLendings();
  };

  const handleReturnBook = async (lendingId) => {
    await returnBook1(lendingId);
    fetchLendings();
  };

  return (
    <div className="container">
      <h2>ניהול השאלות</h2>
      <form>
        <input type="text" name="customerId" placeholder="מזהה לקוח" value={form.customerId} onChange={handleInputChange} />
        <input type="text" name="bookId" placeholder="מזהה ספר" value={form.bookId} onChange={handleInputChange} />
        <input type="date" name="lendingDate" placeholder="תאריך השאלה" value={form.lendingDate} onChange={handleInputChange} />
        <button type="button" onClick={handleAddLending}>הוסף השאלה</button>
      </form>

      <div style={{ marginTop: '2em' }}>
        <input type="text" placeholder="חפש השאלות לפי מזהה לקוח" value={searchId} onChange={(e) => setSearchId(e.target.value)} />
        <button onClick={handleSearchById}>חפש</button>
      </div>

      <div style={{ marginTop: '2em' }}>
        <input type="text" placeholder="הזן מזהה לקוח לתשלום" value={payId} onChange={(e) => setPayId(e.target.value)} />
        <button onClick={handlePay}>שלם</button>
        {payAmount !== null && <p>סכום לתשלום: ₪{payAmount.toFixed(2)}</p>}
      </div>

      <table border="1" style={{ marginTop: '2em', width: '100%', textAlign: 'center' }}>
        <thead>
          <tr>
            <th>מזהה</th>
            <th>מזהה לקוח</th>
            <th>מזהה ספר</th>
            <th>תאריך השאלה</th>
            <th>פעולות</th>
          </tr>
        </thead>
        <tbody>
          {lendings.map((l) => (
            <tr key={l.lendingId}>
              <td>{l.lendingId}</td>
              <td>{l.customerId}</td>
              <td>{l.bookId}</td>
              <td>{l.lendingDate}</td>
     <td>
  {l.returned ? (
    <span>הספר הוחזר</span>
  ) : (
    <button onClick={() => handleReturnBook(l.lendingId)}>סמן כהוחזר</button>
  )}
</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default LendingManager;
