;;; Sierra Script 1.0 - (do not remove this comment)
(script# 92)
(include sci.sh)
(use Main)
(use Game)
(use Obj)

(public
	intro 0
)

(local
	local0
	local1 =  100
)
(instance intro of Rgn
	(properties)
	
	(method (init)
		(super init:)
		(gIconBar disable:)
		(gIconBar disable: 7)
		(gGame setCursor: 996 1 304 172)
		(gUser canInput: 1)
		(gLb2KDH addToFront: self)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(== (pEvent type?) evKEYBOARD)
				(== (pEvent message?) KEY_ESCAPE)
			)
			(pEvent claimed: 1)
			(global2 setScript: sFadeToBlack)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLb2KDH delete: self)
		(= initialized 0)
		(if
			(not
				(= keep
					(proc999_5
						newRoomNumber
						100
						105
						110
						120
						140
						150
						155
						160
						180
						190
						220
					)
				)
			)
			(gIconBar enable:)
		)
	)
)

(instance sFadeToBlack of Script
	(properties)
	
	(method (doit)
		(if (and local0 local1)
			(Palette palSET_INTENSITY 0 255 (-- local1))
			(if (not local1) (self cue:))
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= local0 1))
			(1 (global2 newRoom: 26))
		)
	)
)
