// Copyright (c) 2009 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.sdk;

import java.net.SocketAddress;
import java.util.logging.Logger;

import org.chromium.sdk.internal.BrowserFactoryImpl;

/**
 * A factory for Browser instances.
 * TODO: reflect that it only creates standalone client, no browser.
 */
public abstract class BrowserFactory {
  /**
   * Gets a {@link BrowserFactory} instance. This method should be overridden by
   * implementations that want to construct other implementations of
   * {@link Browser}.
   *
   * @return a BrowserFactory singleton instance
   */
  public static BrowserFactory getInstance() {
    return BrowserFactoryImpl.INSTANCE;
  }

  /**
   * Constructs StandaloneVm instance that talks to a V8 JavaScript VM via
   * DebuggerAgent opened at {@code socketAddress}.
   * @param socketAddress V8 DebuggerAgent is listening on
   * @param connectionLogger provides facility for listening to network
   *        traffic; may be null
   */
  public abstract StandaloneVm createStandalone(SocketAddress socketAddress,
      ConnectionLogger connectionLogger);

  /**
   * @return SDK root logger that can be used to add handlers or to adjust log level
   */
  public static Logger getRootLogger() {
    return LOGGER;
  }

  private static final Logger LOGGER = Logger.getLogger("org.chromium.sdk");
}
