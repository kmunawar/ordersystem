package ordersystem.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ordersystem.database.BlockedTokenRepository;
import ordersystem.model.BlockedToken;

/**
 * @author Mian Munawar
 *
 */
@Service
public class BlockedTokenService {
	
	@Autowired
	private BlockedTokenRepository blockedTokenRepository;
	
	public List<BlockedToken> getAllBlockedTokens() {
		List<BlockedToken> blockedTokens = new ArrayList<BlockedToken>();
		blockedTokenRepository.findAll().forEach(blockedTokens::add);
		return blockedTokens;
	}
	
	public BlockedToken getBlockedToken(String blockedToken) {
		Optional<BlockedToken> optional =  blockedTokenRepository.findById(blockedToken);
		if (!optional.isPresent()) {
			optional = Optional.of(new BlockedToken(""));
		}
		return optional.get();
	}
	
	public void addBlockedToken(BlockedToken blockedToken) {
		blockedTokenRepository.save(blockedToken);
	}
	
	public void deleteUser(String blockedToken) {
		blockedTokenRepository.deleteById(blockedToken);
	}
	
}
