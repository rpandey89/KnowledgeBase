/**
 * Created by rahul.pandey on 5/13/17.
 */

const h2Selector = document.querySelector('.jump');
function spanWrap(word) {
    return [...word].map(char => `<span>${char}</span>`).join('');
}
//assigning a string
h2Selector.innerHTML = spanWrap(h2Selector.textContent);
