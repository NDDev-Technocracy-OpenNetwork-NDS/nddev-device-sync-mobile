#!/usr/bin/env python3
"""Use the selected Shared source's verified native build entry point."""
import json
from pathlib import Path
import subprocess
import sys
from urllib.parse import urljoin, urlparse

configuration = Path(".dart_tool/package_config.json").resolve()
packages = json.loads(configuration.read_text())["packages"]
selected = [item for item in packages if item["name"] == "nds_ui"]
if len(selected) != 1:
    raise SystemExit("Run flutter pub get for the selected Shared source first")
uri = urlparse(urljoin(configuration.as_uri(), selected[0]["rootUri"]))
if uri.scheme != "file" or uri.netloc not in ("", "localhost"):
    raise SystemExit("Shared build requires a local resolved package")
from urllib.request import url2pathname
shared = Path(url2pathname(uri.path)).resolve().parents[1]
raise SystemExit(subprocess.run([sys.executable, str(shared / "scripts/build.py"), *sys.argv[1:]]).returncode)
