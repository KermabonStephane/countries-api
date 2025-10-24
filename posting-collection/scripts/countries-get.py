import httpx

from posting import Posting


def on_response(response: httpx.Response, posting: Posting) -> None:
    # Print the status code of the response to the log.
    print(response.status_code)
