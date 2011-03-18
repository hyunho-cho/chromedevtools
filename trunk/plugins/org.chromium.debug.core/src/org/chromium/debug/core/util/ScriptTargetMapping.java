// Copyright (c) 2010 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.debug.core.util;

import org.chromium.debug.core.model.RunningTargetData;
import org.chromium.debug.core.model.VmResource;
import org.chromium.sdk.JavascriptVm;
import org.eclipse.core.resources.IFile;

/**
 * Describes a relation between a file in workspace {@link IFile} and a script
 * on remote VM {@link VmResource}. A file may participate in several mappings simultaneously.
 */
public class ScriptTargetMapping {
  private final IFile file;
  private final VmResource vmResource;
  private final VmResource.ScriptHolder scriptHolder;
  private final RunningTargetData runningTargetData;

  public ScriptTargetMapping(IFile file, VmResource vmResource,
      VmResource.ScriptHolder scriptHolder, RunningTargetData runningTargetData) {
    this.file = file;
    this.vmResource = vmResource;
    this.scriptHolder = scriptHolder;
    this.runningTargetData = runningTargetData;
  }

  public IFile getFile() {
    return file;
  }

  public VmResource getVmResource() {
    return vmResource;
  }

  public VmResource.ScriptHolder getScriptHolder() {
    return scriptHolder;
  }

  public JavascriptVm getJavascriptVm() {
    return runningTargetData.getJavascriptVm();
  }

  public RunningTargetData getRunningTargetData() {
    return runningTargetData;
  }
}