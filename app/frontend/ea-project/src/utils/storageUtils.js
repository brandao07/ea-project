// src/utils/storageUtils.js

/**
 * Sets multiple items in localStorage.
 * @param {Object} items - An object containing key-value pairs to be stored in localStorage.
 */
export function setLocalStorageItems(items) {
  for (const [key, value] of Object.entries(items)) {
    localStorage.setItem(key, value);
  }
}

/**
 * Removes multiple items from localStorage.
 * @param {Array} keys - An array of keys of the items to be removed from localStorage.
 */
export function removeLocalStorageItems(keys) {
  keys.forEach((key) => {
    localStorage.removeItem(key);
  });
}
