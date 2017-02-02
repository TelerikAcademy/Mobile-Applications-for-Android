/* globals module Promise setTimeout */

module.exports = {
    wait(time) {
        return new Promise((resolve) => {
            setTimeout(resolve, time);
        });
    }
};