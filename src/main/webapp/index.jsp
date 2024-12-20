<html>
<body>
    <h1>Currency Converter</h1>
    <form action="ConvertServlet" method="post">
        <label for="amount">Amount in Euros:</label>
        <input type="number" name="amount" required>
        <label for="currency">Currency:</label>
        <select name="currency">
            <!-- Dynamically populate currencies using the SOAP service -->
        </select>
        <button type="submit">Convert</button>
    </form>
</body>
</html>