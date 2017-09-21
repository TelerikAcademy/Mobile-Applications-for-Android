/* globals module */

module.exports = {
    map(obj, ...props) {
        if (Array.isArray(props[0])) {
            props = props[0];
        }

        let mapped = {};
        props
            .forEach(key => {
                mapped[key] = obj[key];
            });

        return mapped;
    }
};