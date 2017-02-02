/* globals module require __dirname Promise */

const path = require("path");

const low = require("lowdb");
const db = low(path.join(__dirname, "../db/db.json"));
db._.mixin(require("underscore-db"));
db.defaults({
    books: []
}).value();

module.exports = {
    getAllBooks() {
        let books = db.get("books")
            .value();
        return Promise.resolve(books);
    },
    getBookById(id) {
        let book = db.get("books")
            .getById(id)
            .value();
        return Promise.resolve(book);
    },
    addBook(book) {
        const newBook = db.get("books")
            .insert(book)
            .value();
        Promise.resolve(newBook);
    }
};