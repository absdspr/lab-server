export default async function fetchJson(url) {
    const response = await fetch(url);
    return response.json();
};
