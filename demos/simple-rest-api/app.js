/* globals require console */

const express = require("express"),
    bodyParser = require("body-parser");

const waiter = require("./utils/waiter");

const data = require("./data");

const mapper = require("./utils/mapper");

let app = express();

app.use(bodyParser.json());

app.get("/api/books", (req, res) => {
    waiter.wait(1000)
        .then(() => data.getAllBooks())
        .then(books => books.map(book => mapper.map(book, "id", "title")))
        .then(books => res.send(books));
});

app.get("/api/books/:id", (req, res) => {
    waiter.wait(1000)
        .then(() => data.getBookById(req.params.id))
        .then(book => mapper.map(book, "id", "title", "description"))
        .then(book => res.send(book));
});

app.post("/api/books", (req, res) => {
    console.log(req.body);
    let book = req.body;
    waiter.wait(1000)
        .then(() => data.addBook(book))
        .then(newBook => res.send(newBook));
});

app.listen(3001,
    () => console.log("Application running at :3001"));